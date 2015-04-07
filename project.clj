(defproject mad-scientist.club "0.0.0"
  :description "A club for mad scientists. Or at least one."
  :url "https://www.mad-scientist.club/"
  :license {:name "WTFPL"
            :url "http://www.wtfpl.net/"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [ring/ring-devel "1.3.2"]
                 [compojure "1.3.1"]
                 [ring-server "0.4.0"]
                 [cryogen-markdown "0.1.1"]
                 [cryogen-core "0.1.20"]]
  :plugins [[lein-ring "0.8.13"]]
  :main cryogen.core
  :ring {:init cryogen.server/init
         :handler cryogen.server/handler})
