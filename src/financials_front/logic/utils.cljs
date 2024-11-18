(ns financials-front.logic.utils)

(defn get-view-by-name [routes name]
  (-> (some (fn [[_ route-data]]
              (println (str (:name route-data) name))
          (when (= (:name route-data) name)
            (:view route-data)))
        routes)))