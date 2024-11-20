(ns financials-front.views.layout
  (:require
    [financials-front.events-subs :as events]
    [financials-front.views.pages.core.displays.not-found :as displays.not-found]
    [re-frame.core :as rf]))

(defn app []
  (let [{{:keys [view]} :data :as route} @(rf/subscribe [::events/current-route])]
    [:<>
     (if view
       [view route]
       [displays.not-found/not-found])]))