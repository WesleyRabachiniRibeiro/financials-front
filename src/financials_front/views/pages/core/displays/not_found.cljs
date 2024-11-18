(ns financials-front.views.pages.core.displays.not-found
  (:require
   [financials-front.views.components.page :as page]))

(defn not-found
  []
  [page/page
   [:p "Not Found"]])