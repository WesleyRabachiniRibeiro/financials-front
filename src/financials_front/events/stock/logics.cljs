(ns financials-front.events.stock.logics)

(def url "https://673cec1a4db5a341d8336b70.mockapi.io/api/stock/1/list")

(defn fetch-stock-list
  [_ _]
  {:fx/http-get {:uri        (str url)
                 :on-success [:stock/save-stock-list]}})

(defn save-stock-list
  [db [_ response]]
  (assoc-in db [:financials :stock-list :data] response))

