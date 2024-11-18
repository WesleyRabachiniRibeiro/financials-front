(ns financials-front.events-subs
  (:require
   [re-frame.core :as rf]
   [financials-front.effects :as effects]
   [reitit.frontend.controllers :as rfc]
   [financials-front.db :as db]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-sub
  ::name
  (fn [db]
      (:name db)))

(rf/reg-event-fx
  ::navigate
  (fn [_ [_ & route]]
    {::effects/navigate! route}))

(rf/reg-event-db
  ::navigated
  (fn [{{:keys [controllers]} :current-route :as db} [_ new-match]]
    (let [new-route (assoc new-match
                      :controllers (rfc/apply-controllers controllers new-match))]
      (assoc db :current-route new-route))))