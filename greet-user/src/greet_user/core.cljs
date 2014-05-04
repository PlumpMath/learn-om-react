(ns greet-user.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(defn- get-value [e]
  (.. e -target -value))

(defmulti handle-on-change (fn [field e owner state] field))

(defmethod handle-on-change :name [_ e owner {:keys [name]}]
  (let [value (get-value e)]
    (if-not (re-find #"[0-9]" value)
      (om/set-state! owner :name value)
      (om/set-state! owner :name name))))

(defmethod handle-on-change :greet [_ e owner {:keys [greet]}]
  (let [value (get-value e)]
    (om/set-state! owner :greet value)))

(defn greet-view [app owner]
  (reify
    om/IInitState
    (init-state [_]
                {:name "Jitendra"
                 :greet "Hello"})

    om/IRenderState
    (render-state [this state]
                  (dom/div nil
                           (dom/div nil
                                    (dom/select #js
                                                {:ref "greet"
                                                 :value (:greet state)
                                                 :onChange #(handle-on-change :greet % owner state)}
                                                (dom/option #js {:value "Hello"} "Hello")
                                                (dom/option #js {:value "Bye"} "Bye")))
                           (dom/div nil
                                    (dom/input #js
                                               {:type "text" :ref "user-name"
                                                :placeholder "username"
                                                :value (:name state)
                                                :onChange #(handle-on-change :name % owner state)}))
                           (dom/div nil
                                    (dom/h2 nil (str (:greet state) ", " (:name state))))))))

(om/root
  greet-view
  nil
  {:target (. js/document (getElementById "app"))})
