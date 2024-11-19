(ns financials-front.views.pages.stocks.displays.stock-list
  (:require
    ["@mui/material" :refer [Grid Card Typography Button Link]]
    ["@mui/x-data-grid" :refer [DataGrid]]
    [financials-front.views.components.page :as page]
    [financials-front.views.components.breadcrumb :as breadcrumb]
    [reagent.core :as r]))

(def data
  [{:id 1 :symbol "AAPL" :name "Apple Inc." :price 150.2 :pe 22.5 :market-cap 2400000000000 :volume 75000000}
   {:id 2 :symbol "TSLA" :name "Tesla Inc." :price 850.0 :pe 55.2 :market-cap 1100000000000 :volume 50000000}
   {:id 3 :symbol "AMZN" :name "Amazon.com" :price 3200.0 :pe 65.3 :market-cap 1600000000000 :volume 40000000}
   {:id 4 :symbol "AAPL" :name "Apple Inc." :price 150.2 :pe 22.5 :market-cap 2400000000000 :volume 75000000}
   {:id 5 :symbol "TSLA" :name "Tesla Inc." :price 850.0 :pe 55.2 :market-cap 1100000000000 :volume 50000000}
   {:id 6 :symbol "AMZN" :name "Amazon.com" :price 3200.0 :pe 65.3 :market-cap 1600000000000 :volume 40000000}
   {:id 7 :symbol "AAPL" :name "Apple Inc." :price 150.2 :pe 22.5 :market-cap 2400000000000 :volume 75000000}
   {:id 8 :symbol "TSLA" :name "Tesla Inc." :price 850.0 :pe 55.2 :market-cap 1100000000000 :volume 50000000}
   {:id 9 :symbol "AMZN" :name "Amazon.com" :price 3200.0 :pe 65.3 :market-cap 1600000000000 :volume 40000000}
   {:id 10 :symbol "AAPL" :name "Apple Inc." :price 150.2 :pe 22.5 :market-cap 2400000000000 :volume 75000000}])

(defn link-field [params]
  (let [value (:value (js->clj params :keywordize-keys true))]
    (r/as-element
      [:> Link {:color :primary
                :underline :hover
                :href (str "/stocks/" value)}
       value])))

(def columns
  [{:field "symbol" :headerName "Symbol" :flex 1
    :renderCell link-field}
   {:field "name" :headerName "Company Name" :flex 2}
   {:field "price" :headerName "Price ($)"  :flex 1}
   {:field "pe" :headerName "P/E Ratio"  :flex 1}
   {:field "market-cap" :headerName "Market Cap" :flex 1
    :valueFormatter (fn [market]
                      (str "U$" (.toFixed (/ market 1000000000) 2) "B"))}
   {:field "volume" :headerName "Volume" :flex 1}])


(defn stock-list []
  [page/page
   [breadcrumb/breadcrumb [{:name "Home" :route "/"}
                           {:name "Stocks" :route "/stocks"}]]
   [:> Typography {:variant :h3 :gutterBottom true} "Stock Options"]
   [:> Grid {:container true :columns 16 :spacing 3}
    [:> Grid {:item true :xs 16 :style {:padding-top :0 :padding-left :0}}
     [:> DataGrid {:rows                           data
                   :disable-auto-size              true
                   :disable-column-resize          true
                   :disable-row-selection-on-click true
                   :page-size-options              [10]
                   :initial-state                  {:pagination {:pagination-model {:page-size 10}}}
                   :columns                        columns}]]]])
