(ns financials-front.routes
  (:require
   [financials-front.events-subs :as events]
   [financials-front.views.main :as views.main]
   [financials-front.views.stock-list :as views.stock-list]
   [financials-front.views.stock :as views.stock]
   [re-frame.core :as rf]
   [reitit.frontend :as rfr]
   [reitit.frontend.easy :as rfe]))

(def all
  [["/"
    {:name :routes/main
     :view #'views.main/main-panel}]
   ["/stocks"
    {:name        :routes/stocks
     :view        #'views.stock-list/stock-list
     :controllers [{:start #(rf/dispatch [:stock/fetch-stock-list])}]}]
   ["/stocks/:symbol"
    {:name        :routes/stock
     :view        #'views.stock/view}]])

(defn on-navigate [new-match]
  (when new-match
    (rf/dispatch [::events/navigated new-match])))

(def router
  (rfr/router all))

(defn init-routes! []
  (rfe/start!
   router
   on-navigate
   {:use-fragment false}))
