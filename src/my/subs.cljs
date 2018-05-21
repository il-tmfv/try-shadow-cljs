(ns my.subs
  (:require [re-frame.core :as re]))

(re/reg-sub
  :click-counter
  (fn [db _]
    (:counter db)))
