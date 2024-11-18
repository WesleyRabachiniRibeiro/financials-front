(ns financials-front.views.pages.stocks.displays.stock-list
  (:require [financials-front.views.components.page :as page]
            ["@mui/material" :refer [Box]]
            ["@mui/x-data-grid" :refer [DataGrid]]))

(def data
  [{:id 1 :symbol "AAPL" :name "Apple Inc." :price 150.2 :pe 22.5 :market-cap 2400000000000 :volume 75000000}
   {:id 2 :symbol "TSLA" :name "Tesla Inc." :price 850.0 :pe 55.2 :market-cap 1100000000000 :volume 50000000}
   {:id 3 :symbol "AMZN" :name "Amazon.com" :price 3200.0 :pe 65.3 :market-cap 1600000000000 :volume 40000000}])

(def columns
  [{:field "symbol" :headerName "Symbol" }
   {:field "name" :headerName "Company Name" }
   {:field "price" :headerName "Price ($)"  :type "number"}
   {:field "pe" :headerName "P/E Ratio"  :type "number"}
   {:field          "market-cap" :headerName "Market Cap":type "number"
    :valueFormatter (fn [params]
                      (str (.toFixed (/ (:value params) 1000000000) 2) "B"))}
   {:field "volume" :headerName "Volume" :type "number"}])

(defn stock-list []
  [page/page
   [:> Box {:width "max-content"}
    [:> DataGrid {:rows               data
                  :columns            columns}]]])
