(ns financials-front.events.stock.logics
  (:require [ajax.core :as ajax]))

(def url "https://673cec1a4db5a341d8336b70.mockapi.io/api/stock/1/list")

(defn fetch-stock-list
  [_ _]
  {:http-xhrio {:method          :get
                :uri             (str url)
                :response-format (ajax/json-response-format  {:keywords? true})
                :timeout         20000
                :on-success      [:stock/save-stock-list]}})

(defn save-stock-list
  [db [_ response]]
  (assoc-in db [:financials :stock-list :data] response))

