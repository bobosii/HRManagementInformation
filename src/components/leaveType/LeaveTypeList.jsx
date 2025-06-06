import React, { useState, useEffect } from 'react';
import {
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Paper,
  IconButton,
  Button,
  Dialog,
  DialogTitle,
  DialogContent,
  DialogActions,
  TextField,
  Box,
  Typography
} from '@mui/material';
import { Edit as EditIcon, Delete as DeleteIcon, Add as AddIcon } from '@mui/icons-material';
import axios from 'axios';

const LeaveTypeList = () => {
  const [leaveTypes, setLeaveTypes] = useState([]);
  const [open, setOpen] = useState(false);
  const [editingLeaveType, setEditingLeaveType] = useState(null);
  const [formData, setFormData] = useState({
    leaveTypeName: '',
    description: ''
  });

  const fetchLeaveTypes = async () => {
    try {
      const response = await axios.get('/api/leave-types');
      setLeaveTypes(response.data.data);
    } catch (error) {
      console.error('Error fetching leave types:', error);
    }
  };

  useEffect(() => {
    fetchLeaveTypes();
  }, []);

  const handleOpen = (leaveType = null) => {
    if (leaveType) {
      setEditingLeaveType(leaveType);
      setFormData({
        leaveTypeName: leaveType.leaveTypeName,
        description: leaveType.description
      });
    } else {
      setEditingLeaveType(null);
      setFormData({
        leaveTypeName: '',
        description: ''
      });
    }
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
    setEditingLeaveType(null);
    setFormData({
      leaveTypeName: '',
      description: ''
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editingLeaveType) {
        await axios.put(`/api/leave-types/${editingLeaveType.id}`, {
          ...formData,
          id: editingLeaveType.id
        });
      } else {
        await axios.post('/api/leave-types', formData);
      }
      handleClose();
      fetchLeaveTypes();
    } catch (error) {
      console.error('Error saving leave type:', error);
    }
  };

  const handleDelete = async (id) => {
    if (window.confirm('Bu izin tipini silmek istediğinizden emin misiniz?')) {
      try {
        await axios.delete(`/api/leave-types/${id}`);
        fetchLeaveTypes();
      } catch (error) {
        console.error('Error deleting leave type:', error);
      }
    }
  };

  return (
    <Box sx={{ p: 3 }}>
      <Box sx={{ display: 'flex', justifyContent: 'space-between', mb: 3 }}>
        <Typography variant="h5" component="h2">
          İzin Tipleri
        </Typography>
        <Button
          variant="contained"
          color="primary"
          startIcon={<AddIcon />}
          onClick={() => handleOpen()}
        >
          Yeni İzin Tipi
        </Button>
      </Box>

      <TableContainer component={Paper}>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>İzin Tipi Adı</TableCell>
              <TableCell>Açıklama</TableCell>
              <TableCell align="right">İşlemler</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {leaveTypes.map((leaveType) => (
              <TableRow key={leaveType.id}>
                <TableCell>{leaveType.leaveTypeName}</TableCell>
                <TableCell>{leaveType.description}</TableCell>
                <TableCell align="right">
                  <IconButton
                    color="primary"
                    onClick={() => handleOpen(leaveType)}
                  >
                    <EditIcon />
                  </IconButton>
                  <IconButton
                    color="error"
                    onClick={() => handleDelete(leaveType.id)}
                  >
                    <DeleteIcon />
                  </IconButton>
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>

      <Dialog open={open} onClose={handleClose}>
        <DialogTitle>
          {editingLeaveType ? 'İzin Tipini Düzenle' : 'Yeni İzin Tipi'}
        </DialogTitle>
        <form onSubmit={handleSubmit}>
          <DialogContent>
            <TextField
              autoFocus
              margin="dense"
              label="İzin Tipi Adı"
              fullWidth
              required
              value={formData.leaveTypeName}
              onChange={(e) =>
                setFormData({ ...formData, leaveTypeName: e.target.value })
              }
            />
            <TextField
              margin="dense"
              label="Açıklama"
              fullWidth
              multiline
              rows={3}
              value={formData.description}
              onChange={(e) =>
                setFormData({ ...formData, description: e.target.value })
              }
            />
          </DialogContent>
          <DialogActions>
            <Button onClick={handleClose}>İptal</Button>
            <Button type="submit" variant="contained" color="primary">
              {editingLeaveType ? 'Güncelle' : 'Kaydet'}
            </Button>
          </DialogActions>
        </form>
      </Dialog>
    </Box>
  );
};

export default LeaveTypeList; 