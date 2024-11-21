(ns financials-front.layout
  (:require
   [financials-front.events-subs :as events]
   [financials-front.views.not-found :as displays.not-found]
   [re-frame.core :as rf]))

(defn app []
  (let [{{:keys [view]} :data :as route} @(rf/subscribe [::events/current-route])]
    [:<>
     (if view
       [view route]
       [displays.not-found/not-found])]))