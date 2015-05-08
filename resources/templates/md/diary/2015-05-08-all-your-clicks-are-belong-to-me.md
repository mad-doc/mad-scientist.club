{:title "All your clicks are belong to ME!"
 :layout :post
 :tags  ["monitoring" "desktop"]}

The other day I was thinking "*What was I thinking?*", and thought I'd
spare a bit of thinking for my future self, by thinking ahead and
monitoring my thoughts. Now, while that is a nice thought, it may not
be fully thought out: for how would you know what you are thinking of,
when you doze off? And what happens when you think of noting down your
thoughts? Do you note that down too? Of course not. Scientific advance
is all about compromises.

So instead of recording our thoughts, what if we recorded our actions?
**Good lord**, that's an amazing idea, isn't it?!

Of course, this is what logging and monitoring is all about, but are
we doing enough? We are monitoring servers, applications, but we're
rarely looking at ourselves, our desktop. Wouldn't it be nice to
stream our desktop events to a server for further processing? Whenever
we launch an application, whenever we go idle, whenever the laptop
goes to sleep, or it wakes up, an event is sent. Whenever we switch
windows, or workspaces or focus, we send a metric about how long the
previous application was used. From this information, we can draw
astonishing conclusions, and even prettier visualisations.

How?
----

Lets suppose we are using the [GNOME](https://www.gnome.org/gnome-3/),
which has an extensible shell, where we can hook into various
stuff. All we have to do is write an extension that captures these
events, and sends them over to [Riemann](http://riemann.io/). It's
that easy.

Any takers? I'm busy thinking of the Next Big Thing.
