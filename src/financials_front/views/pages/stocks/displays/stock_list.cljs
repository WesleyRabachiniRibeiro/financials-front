(ns financials-front.views.pages.stocks.displays.stock-list
  (:require
    ["@mui/material" :refer [Grid Card Typography Button Link]]
    ["@mui/x-data-grid" :refer [DataGrid]]
    [financials-front.views.components.page :as page]
    [financials-front.views.components.breadcrumb :as breadcrumb]
    [re-frame.core :as rf]
    [reagent.core :as r]))

(defn link-field [params]
  (let [value (:value (js->clj params :keywordize-keys true))]
    (r/as-element
      [:> Link {:color     :primary
                :underline :hover
                :href      (str "/stocks/" value)}
       value])))

(def columns
  [{:field "symbol" :headerName "Symbol" :flex 1 :renderCell link-field}
   {:field "name" :headerName "Company Name" :flex 2}
   {:field "currency" :headerName "Currency" :flex 1}
   {:field "exchange" :headerName "Exchange" :flex 1}
   {:field "exchange-short-name" :headerName "Exchange Short Name" :flex 1}])


(defn stock-list []
  (let [stock-list (rf/subscribe [:stock/stock-list])]
    (fn []
      [page/page
       [breadcrumb/breadcrumb [{:name "Home" :route "/"}
                               {:name "Stocks" :route "/stocks"}]]
       [:> Typography {:variant :h3 :gutterBottom true} "Stock Options"]
       [:> Grid {:container true :columns 16 :spacing 3}
        [:> Grid {:item true :xs 16 :style {:padding-top :0 :padding-left :0}}
         [:> DataGrid {:rows                           @stock-list
                       :disable-auto-size              true
                       :disable-column-resize          true
                       :disable-row-selection-on-click true
                       :page-size-options              [10]
                       :initial-state                  {:pagination {:pagination-model {:page-size 10}}}
                       :columns                        columns}]]]])))
