(ns ls.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(defonce app-state (r/atom {:text "Hello Chestnut!"}))

(defn start []
  (r/render-component
    [:div (:text @app-state)]
    (.getElementById js/document "app")))

(start)