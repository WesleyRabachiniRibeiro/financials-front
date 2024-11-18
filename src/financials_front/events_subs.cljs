(ns financials-front.events-subs
  (:require
   [financials-front.db :as db]
   [financials-front.effects :as effects]
   [re-frame.core :as rf]
   [reitit.frontend.controllers :as rfc]))

(rf/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(rf/reg-sub
 ::current-route
 (fn [db]
   (:current-route db)))

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