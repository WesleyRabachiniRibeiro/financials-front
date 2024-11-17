(ns financials-front.views.pages.core.main
  (:require [financials-front.views.components.page :as page]
            ["@mui/material" :refer [Box AppBar Toolbar]]
            ["@toolpad/core" :refer [DashboardLayout AppProvider PageContainer]]
            ["@mui/material/styles" :refer [createTheme]]))

(defn main-panel
      [& content]
      [page/page
       [:p "Hello World"]])
