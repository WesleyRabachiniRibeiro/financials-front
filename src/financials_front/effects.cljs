(ns financials-front.effects
  (:require
   [re-frame.core :as rf]
   [reitit.frontend.easy :as rfe]))

(rf/reg-fx
 ::navigate!
 (fn [route]
   (apply rfe/push-state route)))