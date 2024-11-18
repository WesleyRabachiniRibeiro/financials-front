(ns financials-front.views.layout
  (:require
   [financials-front.events-subs :as events]
   [financials-front.views.pages.core.displays.not-found :as displays.not-found]
   [re-frame.core :as rf]))

(defn app []
  (let [current-view (rf/subscribe [::events/current-route])]
    [:<>
     (if @current-view
       [(-> @current-view :data :view)]
       [displays.not-found/not-found])]))