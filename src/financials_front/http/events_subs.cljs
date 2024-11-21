(ns financials-front.http.events-subs
  (:require
   [ajax.core :as ajax]
   [day8.re-frame.http-fx :as http-fx]
   [re-frame.core :as rf]))

(rf/reg-sub
 :loading
 (fn [db]
   (get db :loading)))

(rf/reg-event-db
 ::loading
 (fn [db [_ status]]
   (assoc db :loading status)))

(rf/reg-event-fx
 ::on-response
 (fn [_ [_ events response]]
   (let [event-vec (if (-> events first vector?) events (conj [] events))
         dispatchs (map #(into [] [:dispatch (conj % response)]) event-vec)]
     {:fx (concat dispatchs
                  [[:dispatch [::loading false]]])})))

(rf/reg-fx
 :fx/http-get
 (fn [{:keys [uri on-success on-failure]}]
   (http-fx/http-effect {:method          :get
                         :uri             uri
                         :response-format (ajax/json-response-format {:keywords? true})
                         :timeout         8000
                         :on-success      [::on-response on-success]
                         :on-failure      [::on-response on-failure]
                         :on-request      [::loading true]})))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(rf/reg-event-fx
 :http-post
 (fn [{:keys [uri params on-success on-failure]}]
   (http-fx/http-effect {:method          :post
                         :uri             uri
                         :params          params
                         :response-format (ajax/json-response-format {:keywords? true})
                         :timeout         8000
                         :on-success      [::on-response on-success]
                         :on-failure      [::on-response on-failure]
                         :on-request      [::loading true]})))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(rf/reg-event-fx
 :http-put
 (fn [{:keys [uri params on-success on-failure]}]
   (http-fx/http-effect {:method          :put
                         :uri             uri
                         :params          params
                         :response-format (ajax/json-response-format {:keywords? true})
                         :timeout         8000
                         :on-success      [::on-response on-success]
                         :on-failure      [::on-response on-failure]
                         :on-request      [::loading true]})))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(rf/reg-event-fx
 :http-delete
 (fn [{:keys [uri on-success on-failure]}]
   (http-fx/http-effect {:method          :post
                         :uri             uri
                         :response-format (ajax/json-response-format {:keywords? true})
                         :timeout         8000
                         :on-success      [::on-response on-success]
                         :on-failure      [::on-response on-failure]
                         :on-request      [::loading true]})))
