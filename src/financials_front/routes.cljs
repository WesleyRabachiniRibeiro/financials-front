(ns financials-front.routes
  (:require
    [financials-front.events-subs :as events]
    [financials-front.views.pages.core.displays.main :as displays.main]

    [financials-front.views.pages.stocks.displays.stock-list :as displays.stock-list]

    [re-frame.core :as rf]
    [reitit.frontend :as rfr]
    [reitit.frontend.easy :as rfe]))

(def all
  [["/"
    {:name :routes/main
     :view #'displays.main/main-panel}]
   ["/stocks"
    {:name        :routes/stocks
     :view        #'displays.stock-list/stock-list
     :controllers [{:start #(rf/dispatch [:stock/stock-list])}]}]])

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
