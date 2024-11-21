(ns financials-front.views.not-found
  (:require
   [financials-front.components.page :as page]))

(defn not-found
  []
  [page/page
   [:p "Not Found"]])