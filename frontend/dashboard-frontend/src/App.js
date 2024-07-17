import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Dashboard from './component/Dashboard';
import Analytic from './component/Analytic';


function App() {
  return (
      <div>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Dashboard />} />
            <Route path="/analytic" element={<Analytic />} />
            </Routes>
        </BrowserRouter>
      </div>
    )
}

export default App;
