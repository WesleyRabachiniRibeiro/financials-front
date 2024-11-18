(ns financials-front.config
  (:require
   [financials-front.routes :as routes]))

(def config
  {:app-name "financials"
   :routes routes/all})