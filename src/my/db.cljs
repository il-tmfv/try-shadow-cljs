(ns my.db
  (:require [clojure.spec.alpha :as s]
            [re-frame.core :as re]))

(s/def ::counter string?)
(s/def ::db (s/keys :req-un [::counter]))

(defn- check-db [spec db]
  (when (not (s/valid? spec db))
    (throw (ex-info (str "DB is incorrect: " (s/explain-str spec db)) {}))))

(def check-db-interceptor (re/after (partial check-db ::db)))
