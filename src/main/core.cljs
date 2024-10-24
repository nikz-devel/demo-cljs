(ns core
  (:require [reagent.dom :as dom]
            ["sweetalert2$default" :as Swal]))

(defn simple-component []
  [:div
   [:p "Hello from super component!"]
   [:button.text-white.bg-blue-500.font-medium.rounded.text-sm.px-3.py-2.mr-2.mb-2
    {:type "button"
     :class ["hover:bg-blue-600"
             "focus:ring-4"
             "focus:ring-blue-300"]
     :on-click #(.fire Swal (clj->js {:title "It`s work!"
                                      :text "emmmmaaaa"
                                      :icon "success"
                                      :confirmButtonText "Cool"}))}
    "Default"]])

(defn app []
  [simple-component])

(defn ^:dev/after-load start []
  (dom/render [app]
              (.getElementById js/document "app")))

(defn init []
  (start))

