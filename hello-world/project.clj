(defproject hello-world "0.1.0"
  :description "Hello World!"
  :url "http://jittakal.blogspot.com"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2197"]
                 [om "0.6.2"]]

  :plugins [[lein-cljsbuild "1.0.3"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "hello-world"
              :source-paths ["src"]
              :compiler {
                :output-to "hello_world.js"
                :output-dir "out"
                :optimizations :none
                :source-map true}}]})
