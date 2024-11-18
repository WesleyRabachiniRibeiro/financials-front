(ns financials-front.routes
  (:require
    [re-frame.core :as rf]
    [reitit.frontend :as rfr]
    [financials-front.events-subs :as events]
    [financials-front.views.pages.core.routes :as core.routes]
    [financials-front.views.pages.stocks.routes :as stocks.routes]
    [reitit.frontend.easy :as rfe]))

(def all
  (concat core.routes/routes
          stocks.routes/routes))

(defn on-navigate [new-match]
  (when new-match
    (rf/dispatch [::events/navigated new-match])))

(def router
  (rfr/router all))

(defn init-routes! []
  (rfe/start!
    router
    on-navigate
    {:use-fragment true}))
