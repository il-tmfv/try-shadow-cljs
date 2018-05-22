(ns my.effects
  (:require [re-frame.core :as re]
            [utils.local-storage :as ls]))

(def ls-key "try-shadow-cljs-ls-key")

(re/reg-cofx
  :read-counter-from-local-storage
  (fn [cofx _]
    (assoc cofx :local-storage-counter-value (or (ls/get-item ls-key) "0"))))

(re/reg-fx
  :save-counter-to-local-storage
  (fn [val]
    (ls/set-item! ls-key val)))
