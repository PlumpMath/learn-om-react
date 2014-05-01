(ns greet-user.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(defn- get-value [e]
  (.. e -target -value))

(defn- handle-change [e owner {:keys [name]}]
  (let [value (get-value e)]
    (if-not (re-find #"[0-9]" value)
      (om/set-state! owner :name value)
      (om/set-state! owner :name name))))

(defn greet-view [app owner]
  (reify
    om/IInitState
    (init-state [_]
                {:name ""})

    om/IRenderState
    (render-state [this state]
                  (dom/div nil
                   (dom/div nil
                    (dom/input #js
                               {:type "text" :ref "user-name"
                                :value (:name state)
                                :onChange #(handle-change % owner state)}))
                           (dom/div nil
                                    (dom/h2 nil (str "Hello, " (:name state))))))))

(om/root
  greet-view
  nil
  {:target (. js/document (getElementById "app"))})
