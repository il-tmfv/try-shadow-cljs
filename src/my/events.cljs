(ns my.events
  (:require [re-frame.core :as re]))

(re/reg-event-fx
  :init-db
  [(re/inject-cofx :read-counter-from-local-storage)]
  (fn [cofx _]
    (let [db (:db cofx)
          init-value (:local-storage-counter-value cofx)]
      {:db (assoc-in db [:counter] (int init-value))})))

(re/reg-event-fx
  :click-event
  (fn [cofx event]
    (let [db (:db cofx)
          old-counter (get-in db [:counter])
          inc-step (second event)
          new-counter (+ inc-step old-counter)]
      {:db            (assoc-in db [:counter] new-counter)
       :save-counter-to-local-storage new-counter})))
