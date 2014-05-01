(ns hello-world.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {:text "Hello World!"}))

(defn hello-world-view [app owner]
  (dom/h1 nil (:text app)))

(om/root
  hello-world-view
  app-state
  {:target (. js/document (getElementById "app"))})
