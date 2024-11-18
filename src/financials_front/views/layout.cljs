(ns financials-front.views.layout
  (:require [financials-front.events-subs :as events]
            [re-frame.core :as rf]))


(defn app []
  (let [current-view (rf/subscribe [::events/current-route])]
     [:<>
      (when @current-view
        [(-> @current-view :data :view)])]))