(ns financials-front.core
  (:require
    [financials-front.routes :as routes]
    [reagent.dom :as dom]
    [re-frame.core :as rf]
    [financials-front.events-subs :as events]
    [financials-front.views.pages.core.displays.main :as displays.main]
    [financials-front.config :as config]))


(defn ^:after-load initialize-app! []
  (rf/clear-subscription-cache!)
  (dom/render [displays.main/main-panel]
             (.getElementById js/document (:app-name config/config))))

(defn init []
  (rf/dispatch-sync [::events/initialize-db])
  (routes/init-routes!)
  (initialize-app!))
