(defproject om-async "0.1.0"
  :description "Om Async Tutorial"
  :url "http://jittakal.blogspot.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :jvm-opts ^:replace ["-Xmx1g" "-server"]

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2197"]
                 [org.clojure/core.async "0.1.301.0-deb34a-alpha"]
                 [om "0.6.2"]
                 [ring/ring "1.2.2"]
                 [compojure "1.1.6"]
                 [fogus/ring-edn "0.2.0"]
                 [com.datomic/datomic-free "0.9.4755"]]

  :dev-dependencies [[lein-ring "0.8.10"]]

  :plugins [[lein-cljsbuild "1.0.3"]
            [lein-ring "0.8.10"]]

  :source-paths ["src/clj" "src/cljs"]
  :resource-paths ["resources"]

  :ring {:handler om-async.core/app}

  :cljsbuild {
    :builds [{:id "dev"
              :source-paths ["src/clj" "src/cljs"]
              :compiler {
                :output-to "resources/public/js/main.js"
                :output-dir "resources/public/js/out"
                :optimizations :none
                :source-map true}}]})
