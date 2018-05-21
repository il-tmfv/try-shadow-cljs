(ns my.events
  (:require [re-frame.core :as re]))

(re/reg-event-db
  :init-db
  (fn [db _]
    (assoc-in db [:counter] 1)))

(re/reg-event-fx
  :click-event
  (fn [cofx event]
    (let [db (:db cofx)
          old-counter (get-in db [:counter])
          inc-step (second event)]
      {:db (assoc-in db [:counter] (+ inc-step old-counter))})))
