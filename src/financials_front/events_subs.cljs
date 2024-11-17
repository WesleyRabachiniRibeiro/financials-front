(ns financials-front.events-subs
  (:require
   [re-frame.core :as rf]
   [financials-front.db :as db]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-sub
  ::name
  (fn [db]
      (:name db)))