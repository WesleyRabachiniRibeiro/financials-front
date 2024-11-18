(ns financials-front.views.pages.stocks.routes
  (:require [financials-front.views.pages.stocks.displays.stock-list :as displays.stock-list]))

(def routes
  [["/stocks"
    {:name :routes/stocks
     :view displays.stock-list/stock-list}]])