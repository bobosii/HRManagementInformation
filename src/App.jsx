import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import { ThemeProvider, createTheme } from '@mui/material';
import LeaveTypeList from './components/leaveType/LeaveTypeList';

const theme = createTheme({
  palette: {
    primary: {
      main: '#1976d2',
    },
    secondary: {
      main: '#dc004e',
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={theme}>
      <Router>
        <Routes>
          <Route path="/leave-types" element={<LeaveTypeList />} />
          {/* Diğer route'lar buraya eklenecek */}
        </Routes>
      </Router>
    </ThemeProvider>
  );
}

export default App; 