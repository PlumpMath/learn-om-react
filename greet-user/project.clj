(defproject greet-user "0.1.0"
  :description "Greet User"
  :url "http://jittakal.blogspot.com"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2197"]
                 [org.clojure/core.async "0.1.301.0-deb34a-alpha"]
                 [om "0.6.2"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "greet-user"
              :source-paths ["src"]
              :compiler {
                :output-to "greet_user.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
