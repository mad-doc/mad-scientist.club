{:title "AST mah' code"
 :layout :post
 :tags  ["hy" "logic-programming"]}

There are tools like [kibit][kibit] and [hydiomatic][hydiomatic],
which help one write better, more idiomatic code in selected
languages. Wouldn't it be too have a similar tool for [Python][python]
too? Something that helps one transform legacy python2 code to
python3? Perhaps powered by the vast amount of such code already
written - by using machine learning to teach the system.

 [kibit]: https://github.com/jonase/kibit
 [hydiomatic]: https://github.com/algernon/hydiomatic
 [python]: https://www.python.org/

The catch is, Python is not homoiconic: python source is not written
using its own data structures. Yet, there is a way to achieve our
goal: we can work on the AST! That's much easier to parse and
transform! We'll still need to convert back to Python, but that does
not have to be a hundred percent accurate. If the tool can give its
user enough hints, then it is useful nevertheless. Although, superior
languages like [Clojure](http://clojure.org/) and
[Hy](http://hylang.org/) make it easier, that is no reason to shove
our lesser, but beloved language under the floor.

Lets dive in with an example! Consider the following ASTs (first in
python2, then in python3):

```python
Module(body=[
  Print(dest=None,
        values=[Str(s='foo!')],
        nl=True)
])
```

```python
Module(body=[
  Expr(value=Call(func=Name(id='print', ctx=Load()),
                  args=[Str(s='foo!')],
                  keywords=[],
                  starargs=None,
                  kwargs=None))
])
```

It is pretty easy to see how the transformation works. We replace the
`Print()` with a function call, move its values to the function call's
`args`. In our imaginary tool, we could write this rule like this:

```clojure
[(print :dest nil :values ?x nl true)
 (expr :value (call :func (name :id "print"
                                :ctx (Load))
                    :args ?x
                    :keywords []
                    :starargs nil
                    :kwargs nil))]
```

All we need is to either write a matcher that understands the AST, or
transform the AST to - for example - Hy, and write rules for
that. Thinking the idea further, one doesn't even need to transform
back to Python: one can just grab the AST from a python2 interpreter,
transform it on the fly to python3 AST, and run it under python3!

Simple, isn't it? Writing a tool that transforms AST to Hy is left as
an exercise for the reader. Once done, my dear reader can plug the
above rule into [Hydiomatic][hydiomatic] and see wonders!

The Machine Learning bridge
---------------------------

But the interesting part comes just now! Who in their right mind would
want to write the rules of transformation? Who would want to verify
them? Noone. The good news is, noone has to! There are millions of
lines of source code out there that have been translated from python2
to python3. All we have to do, is collect a reasonable sample, find
the changes that moved the code from python2 to python3, compare the
ASTs, and voila!

Now, finding commits isn't an easy - or reliable - task, but that's
not going to stop us, would it? Assuming we succeeded, there are
plenty of machine learning tools available that can help us in our
quest. We merely need to discover pattern transitions, and then we can
write our rules.

That is all there is to it. Pretty simple, eh?
