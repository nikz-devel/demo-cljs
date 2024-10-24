(ns core
  (:require [goog.dom :as gdom]
            [reagent.dom :as dom]
            ["sweetalert2$default" :as Swal]))

(defn simple-component []
  [:div
   [:p "Hello from component!"]
   [:button {:on-click #(.fire Swal (clj->js {:title "It`s work!"
                                              :text "emmmmaaaa"
                                              :icon "success"
                                              :confirmButtonTest "Cool"}))} "Click me"]])

(defn init! []
  (dom/render [simple-component] (gdom/getElement "app")))

(comment
  (js/alert "Hello")
  )
