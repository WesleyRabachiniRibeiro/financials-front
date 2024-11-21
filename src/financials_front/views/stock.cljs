(ns financials-front.views.stock
  (:require [financials-front.components.page :as page]
            [clojure.string :as c-str]
            ["@mui/material" :refer [List ListItem ListItemText Divider Grid Typography Link]]
            ["@mui/x-charts" :refer [LineChart]]))

(defn custom-list-item-text
  [{:keys [primary secondary]}]
  [:> ListItemText {:key                      (str primary secondary)
                    :primary                  primary
                    :primaryTypographyProps   {:fontSize 14
                                               :color    "text.secondary"}
                    :secondary                secondary
                    :secondaryTypographyProps {:fontSize 16
                                               :color    "text.primary"}}])

(defn view
  []
  (let [company {:symbol              "AAPL"
                 :price               178.72
                 :beta                1.286802
                 :vol-avg             58405568
                 :mktCap              2794144143933
                 :last-div            0.96
                 :range               "124.17-198.23"
                 :changes             -0.13
                 :company-name        "Apple Inc."
                 :currency            "USD"
                 :cik                 "0000320193"
                 :isin                "US0378331005"
                 :cusip               "037833100"
                 :exchange            "NASDAQ Global Select"
                 :exchange-short-name "NASDAQ"
                 :industry            "Consumer Electronics"
                 :website             "https://www.apple.com"
                 :description         "Apple Inc. designs, manufactures, and markets smartphones..."
                 :ceo                 "Mr. Timothy D. Cook"
                 :sector              "Technology"
                 :country             "US"
                 :full-time-employees "164000"
                 :phone               "408 996 1010"
                 :address             "One Apple Park Way"
                 :city                "Cupertino"
                 :state               "CA"
                 :zip                 "95014"
                 :dcfDiff             4.15176
                 :dcf                 150.082
                 :image               "https://financialmodelingprep.com/image-stock/AAPL.png"
                 :ipoDate             "1980-12-12"
                 :default-image       false
                 :is-etf              false
                 :is-actively-trading true
                 :is-adr              false
                 :is-fund             false}]

    [page/page
     [:div {:style {:display         :flex
                    :flex-direction  :column
                    :align-items     :center
                    :justify-content :center}}
      [:div {:style {:width "70%"}}
       [:> Grid {:container true :columns 16 :row-spacing 2}
        [:> Grid {:item true :xs 4}
         [:div {:style {:width           150
                        :height          150
                        :display         :flex
                        :align-items     :center
                        :justify-content :center
                        :overflow        :hidden
                        :background      "linear-gradient(135deg, #1976D2, #64B5F6, #90CAF9)"
                        :border-radius   "50%"
                        :box-shadow      "0px 0px 15px -7px rgba(0,0,0,0.75)"}}
          [:img {:src   (:image company)
                 :alt   (:company-name company)
                 :style {:object-fit :contain :width 100 :height 100}}]]]
        [:> Grid {:item true :xs 12 :style {:margin-top 20}}
         [:> Link {:variant      :h5
                   :href         (:website company)
                   :target       "_blank"
                   :underline    :none
                   :gutterBottom true}
          (:company-name company)]
         [:> List {:style {:display :flex :flexDirection :row :padding 0 :overflow-x :auto}}
          [:> ListItem {:style {:padding-left 0} :dense true}
           (->> [{:primary   "Symbol"
                  :secondary (:symbol company)}
                 {:primary   "Price"
                  :secondary (str (:currency company) " " (or (:price company) 0))}
                 {:primary   "Exchange"
                  :secondary (:exchange-short-name company)}]
                (map custom-list-item-text))]]]
        [:> Grid {:item true :xs 16}
         [:> Typography {:variant :subtitle1} (:description company)]]]

       [:> Divider {:style {:margin-top 20}}]
       [:> List {:dense true}
        [:> ListItem {:style {:display :grid :grid-template-columns "repeat(4,1fr)" :gap 2}}
         (->> [{:primary   "CEO"
                :secondary (:ceo company)}
               {:primary   "Sector"
                :secondary (str (:sector company))}
               {:primary   "Industry"
                :secondary (:industry company)}
               {:primary   "Last Dividend"
                :secondary (str (:currency company) " " (:last-div company))}]
              (map custom-list-item-text))]]
       [:> ListItem {:style {:display :grid :grid-template-columns "repeat(4,1fr)" :gap 2}}
        (->> [{:primary   "Active for Trading"
               :secondary (c-str/capitalize (str (:is-actively-trading company)))}
              {:primary   "Price"
               :secondary (str (:currency company) " " (:price company))}
              {:primary   "Market Cap"
               :secondary (str (:currency company) " " (:mktCap company))}
              {:primary   "Beta"
               :secondary (:beta company)}]
             (map custom-list-item-text))]
       [:> ListItem {:style {:display :grid :grid-template-columns "repeat(4,1fr)" :gap 2}}
        (->> [{:primary   "Volume (Avg)"
               :secondary (:vol-avg company)}
              {:primary   "Price Range"
               :secondary (:range company)}
              {:primary   "Changes"
               :secondary (:changes company)}
              {:primary   "DCF Value"
               :secondary (str (:currency company) " " (:dcf company))}]
             (map custom-list-item-text))]
       [:> Divider]
       [:> List
        [:> ListItem {:style {:display :grid :grid-template-columns "repeat(4,1fr)" :gap 2}}
         (->> [{:primary   "Country"
                :secondary (:country company)}
               {:primary   "City"
                :secondary (str (:city company) " - " (:state company))}
               {:primary   "Address"
                :secondary (:address company)}
               {:primary   "Phone"
                :secondary (:phone company)}]
              (map custom-list-item-text))]]
       [:> Divider]]]]))
