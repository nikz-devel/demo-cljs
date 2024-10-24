(ns core
  (:require [reagent.dom :as dom]
            ["sweetalert2$default" :as Swal]))

(defn simple-component []
  [:div
   [:p "Hello from super component!"]
   [:button {:on-click #(.fire Swal (clj->js {:title "It`s work!"
                                              :text "emmmmaaaa"
                                              :icon "success"
                                              :confirmButtonTest "Cool"}))} "Click me"]])

(defn app []
  [simple-component])

(defn ^:dev/after-load start []
  (dom/render [app]
              (.getElementById js/document "app")))

(defn init []
  (start))

