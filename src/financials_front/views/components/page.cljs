(ns financials-front.views.components.page
  (:require [reagent.core :as r]
            ["@mui/material" :refer [Box AppBar Toolbar]]
            ["@toolpad/core" :refer [DashboardLayout AppProvider PageContainer]]
            ["@mui/icons-material/AddCard" :default AddCard]
            ["@mui/material/styles" :refer [createTheme]]))

(def theme
  (createTheme
    (clj->js {:cssVariables {:colorSchemeSelector :data-toolpad-color-scheme}
              :colorSchemes {:light true
                             :dark  true}
              :breakpoints  {:values {:xs 0 :sm 600 :md 600 :lg 1200 :xl 1536}}})))

(def navigation
  [{:kind    "header"
    :title   "Finance"}
   {:segment "stocks"
    :title   "Stocks"
    :icon (r/as-element [:> AddCard])}])

(defn page
  [& content]
  [:> AppProvider {:theme    theme
                   :navigation navigation
                   :branding {:title "Financials"}}
   [:> DashboardLayout {:sx {:flex-grow 1}}
    [:> PageContainer
     (if (seq (rest content))
       (apply conj [:<>] content)
       (first content))]]])
