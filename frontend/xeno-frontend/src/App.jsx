import React, { useState, useEffect } from "react";

const TABS = [
  { id: "users", label: "Users" },
  { id: "campaigns", label: "Campaigns" },
];

export default function App() {
  const [activeTab, setActiveTab] = useState("users");
  const [users, setUsers] = useState([]);
  const [campaigns, setCampaigns] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const [darkMode, setDarkMode] = useState(false);

  useEffect(() => {
    setLoading(true);
    setError(null);
    const url =
      activeTab === "users"
        ? "http://localhost:8080/api/users"
        : "http://localhost:8080/api/campaigns";

    fetch(url)
      .then((res) => {
        if (!res.ok) throw new Error("Network response was not ok");
        return res.json();
      })
      .then((data) => {
        if (activeTab === "users") setUsers(data);
        else setCampaigns(data);
        setLoading(false);
      })
      .catch((err) => {
        setError(err.message);
        setLoading(false);
      });
  }, [activeTab]);

  return (
    <div className={`${darkMode ? "bg-gray-900 text-gray-100" : "bg-white text-gray-900"} min-h-screen transition-colors duration-500 font-sans p-8`}>
      <header className="max-w-6xl mx-auto flex justify-between items-center mb-10">
        <div>
          <h1 className="text-5xl font-extrabold tracking-tight mb-1 select-none">
            XENO Dashboard
          </h1>
          <p className={`${darkMode ? "text-gray-400" : "text-gray-600"} text-lg`}>
            Manage your Users and Campaigns seamlessly with style.
          </p>
        </div>
        <button
          onClick={() => setDarkMode((d) => !d)}
          aria-label="Toggle Dark Mode"
          className="px-4 py-2 rounded-full border-2 border-indigo-600 hover:bg-indigo-600 hover:text-white transition"
        >
          {darkMode ? "Light Mode" : "Dark Mode"}
        </button>
      </header>

      <nav className="max-w-6xl mx-auto flex space-x-4 mb-12">
        {TABS.map((tab) => (
          <button
            key={tab.id}
            onClick={() => setActiveTab(tab.id)}
            className={`
              relative px-6 py-3 font-semibold rounded-full transition
              focus:outline-none
              ${
                activeTab === tab.id
                  ? "text-indigo-600 dark:text-indigo-400"
                  : `${darkMode ? "text-gray-400 hover:text-indigo-400" : "text-gray-600 hover:text-indigo-600"}`
              }
            `}
          >
            {tab.label}
            {activeTab === tab.id && (
              <span
                className="absolute bottom-0 left-0 right-0 h-1 rounded-full bg-indigo-600 dark:bg-indigo-400"
                style={{ transformOrigin: "center" }}
              />
            )}
          </button>
        ))}
      </nav>

      <main className="max-w-6xl mx-auto">
        {loading && (
          <p className="text-indigo-600 dark:text-indigo-400 text-center text-xl font-semibold animate-pulse">
            Loading {activeTab}...
          </p>
        )}

        {error && (
          <p className="text-red-500 text-center font-semibold">{error}</p>
        )}

        {!loading && !error && activeTab === "users" && (
          <section className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
            {users.length === 0 ? (
              <p className="col-span-full text-center italic text-gray-500 dark:text-gray-400">
                No users found.
              </p>
            ) : (
              users.map((user) => (
                <article
                  key={user.id}
                  className={`p-6 rounded-xl shadow-md cursor-pointer 
                    transition-transform transform hover:-translate-y-1 hover:shadow-xl
                    ${darkMode ? "bg-gray-800" : "bg-white"}`}
                >
                  <h2 className="text-2xl font-bold text-indigo-600 dark:text-indigo-400 mb-3 select-text">
                    {user.name}
                  </h2>
                  <p className="mb-2 text-gray-700 dark:text-gray-300">
                    <span className="font-semibold">Email:</span> {user.email}
                  </p>
                  <p className="text-sm text-gray-500 dark:text-gray-400">
                    <span className="font-semibold">Role:</span> {user.role || "N/A"}
                  </p>
                </article>
              ))
            )}
          </section>
        )}

        {!loading && !error && activeTab === "campaigns" && (
          <section className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-8">
            {campaigns.length === 0 ? (
              <p className="col-span-full text-center italic text-gray-500 dark:text-gray-400">
                No campaigns found.
              </p>
            ) : (
              campaigns.map((campaign) => (
                <article
                  key={campaign.campaignId}
                  className={`p-6 rounded-xl shadow-md cursor-pointer 
                    transition-transform transform hover:-translate-y-1 hover:shadow-xl
                    ${darkMode ? "bg-gray-800" : "bg-white"}`}
                >
                  <h2 className="text-2xl font-bold text-indigo-600 dark:text-indigo-400 mb-3 select-text">
                    {campaign.title}
                  </h2>
                  <p className="mb-4 text-gray-700 dark:text-gray-300 line-clamp-3">
                    {campaign.message}
                  </p>
                  <div className="flex justify-between text-sm text-gray-500 dark:text-gray-400">
                    <span>Status: {campaign.status}</span>
                    <span>
                      Scheduled:{" "}
                      {campaign.scheduledAt
                        ? new Date(campaign.scheduledAt).toLocaleString()
                        : "N/A"}
                    </span>
                  </div>
                </article>
              ))
            )}
          </section>
        )}
      </main>
    </div>
  );
}
