(ns financials-front.views.components.breadcrumb
  (:require
    ["@mui/material/Breadcrumbs" :default Breadcrumbs]
    ["@mui/material/Link" :default Link]
    [schema.core :as s]))

(s/defschema breadcrumbProp
  {:name  s/Str
   :route s/Str})


(s/defn breadcrumb [breadcrumbProp :- breadcrumbProp]
  [:> Breadcrumbs {:aria-label "breadcrumb"
                   :style {:margin-bottom 20}}
   (for [{:keys [name route]} breadcrumbProp]
     [:> Link {:underline :hover
               :color     :inherit
               :href      route
               :key       name}
      name])])
