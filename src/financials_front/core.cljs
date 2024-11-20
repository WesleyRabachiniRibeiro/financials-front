(ns financials-front.core
  (:require
   [financials-front.config :as config]
   [financials-front.events-subs :as events]
   [financials-front.routes :as routes]
   [financials-front.views.layout :as views.layout]
   [day8.re-frame.http-fx]
   [devtools.core :as devtools]
   [financials-front.events.events]
   [re-frame.core :as rf]
   [reagent.dom :as dom]))

(defn ^:after-load initialize-app! []
  (rf/clear-subscription-cache!)
  (dom/render [views.layout/app] (.getElementById js/document (:app-name config/config))))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn init []
  (rf/dispatch-sync [::events/initialize-db])
  (devtools/install!)
  (routes/init-routes!)
  (initialize-app!))
