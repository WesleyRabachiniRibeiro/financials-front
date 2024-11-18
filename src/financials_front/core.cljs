(ns financials-front.core
  (:require
    [financials-front.routes :as routes]
    [reagent.dom :as dom]
    [re-frame.core :as rf]
    [financials-front.events-subs :as events]
    [financials-front.views.layout :as views.layout]
    [financials-front.config :as config]))


(defn ^:after-load initialize-app! []
  (rf/clear-subscription-cache!)
  (dom/render [views.layout/app]
             (.getElementById js/document (:app-name config/config))))

(defn init []
  (rf/dispatch-sync [::events/initialize-db])
  (routes/init-routes!)
  (initialize-app!))
