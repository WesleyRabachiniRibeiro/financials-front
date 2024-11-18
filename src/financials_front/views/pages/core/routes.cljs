(ns financials-front.views.pages.core.routes
  (:require [financials-front.views.pages.core.displays.main :as displays.main]))

(def routes
  [["/"
    {:name :routes/main
     :view displays.main/main-panel}]])