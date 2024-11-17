(ns financials-front.views.components.page
  (:require [re-frame.core :as re-frame]
            ["@mui/material" :refer [Box AppBar Toolbar]]
            ["@toolpad/core" :refer [DashboardLayout AppProvider PageContainer]]
            ["@mui/material/styles" :refer [createTheme]]))

(def theme
  (createTheme
    (clj->js {:cssVariables {:colorSchemeSelector :data-toolpad-color-scheme}
              :colorSchemes {:light true
                             :dark  true}
              :breakpoints  {:values {:xs 0 :sm 600 :md 600 :lg 1200 :xl 1536}}})))

(def navigation
  [{:kind    "header"
    :title   "Main items"}
   {:segment "dashboard"
    :title   "Dashboard"}
   {:segment "orders"
    :title   "Orders"}])

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
