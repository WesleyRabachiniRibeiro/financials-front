(ns financials-front.events.stock.events-subs
  (:require [re-frame.core :as rf]
            [financials-front.events.stock.logics :as stock.logics]))

(rf/reg-sub
  :stock/stock-list
  (fn [db]
    (get-in db[:financials :stock-list :data])))

(rf/reg-event-db :stock/save-stock-list stock.logics/save-stock-list)

(rf/reg-event-fx :stock/stock-list stock.logics/fetch-stock-list)

