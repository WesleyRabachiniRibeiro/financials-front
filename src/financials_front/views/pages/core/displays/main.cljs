(ns financials-front.views.pages.core.displays.main
  (:require [financials-front.views.components.page :as page]
            [reitit.frontend.easy :as rfe]))

(defn main-panel
      [& content]
      [page/page
       [:a {:href (rfe/href :routes/stocks)} "Stock List"]
       [:p "Hello World"]])
